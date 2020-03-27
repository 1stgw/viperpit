package de.viperpit.agent.data;

import static com.sun.jna.Native.register;
import static com.sun.jna.Native.setProtected;
import static com.sun.jna.platform.win32.WinNT.PAGE_READWRITE;
import static com.sun.jna.platform.win32.WinNT.SECTION_MAP_READ;
import static com.sun.jna.platform.win32.WinNT.SECTION_MAP_WRITE;
import static java.lang.System.loadLibrary;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Optional;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD.SIZE_T;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinNT.MEMORY_BASIC_INFORMATION;

public class SharedMemory implements Closeable {

	private static final int PAGE_ACCESS = PAGE_READWRITE;

	private static final int VIEW_ACCESS = SECTION_MAP_READ | SECTION_MAP_WRITE;

	static {
		register("Kernel32");
		setProtected(true);
		loadLibrary("Kernel32");
	}

	private final Optional<HANDLE> handle;

	private final int size;

	private boolean valid;

	private final Optional<Pointer> view;

	public SharedMemory(String name) {
		this.handle = openHandle(name);
		if (handle.isPresent()) {
			this.view = handle.flatMap(h -> mapView(handle.get()));
			this.size = findSize(view.get());
		} else {
			this.view = empty();
			this.size = -1;
		}
		if (handle.isPresent() && view.isPresent() && size > 0) {
			this.valid = true;
		} else {
			this.valid = false;
			close();
			throw new IllegalArgumentException("Shared Memory area " + name + " is not readable.");
		}
	}

	@Override
	public void close() {
		valid = false;
		view.map(p -> Kernel32.INSTANCE.UnmapViewOfFile(p));
		handle.map(h -> Kernel32.INSTANCE.CloseHandle(h));
	}

	private byte[] copy() {
		byte[] out = new byte[size];
		read(out, Math.min(out.length, size));
		return out;
	}

	private int findSize(Pointer pointer) {
		if (pointer != null) {
			MEMORY_BASIC_INFORMATION info = new MEMORY_BASIC_INFORMATION();
			VirtualQuery(pointer, info, new SIZE_T(info.size()));
			return info.regionSize.intValue();
		} else {
			return 0;
		}
	}

	private Optional<Integer> flush() {
		return view.map(p -> FlushViewOfFile(p, new SIZE_T(size)));
	}

	private native int FlushViewOfFile(Pointer p, SIZE_T n);

	private Optional<ByteBuffer> getByteBuffer() {
		return getView().map(p -> p.getByteBuffer(0, size));
	}

	public Optional<Pointer> getView() {
		return view;
	}

	private void initialize() {
	}

	private Optional<Pointer> mapView(HANDLE handle) {
		return validate(Kernel32.INSTANCE.MapViewOfFile(handle, VIEW_ACCESS, 0, 0, 0), (Pointer p) -> p);
	}

	private native long OpenFileMappingA(DWORD access, boolean bInheritHandle, String s);

	private Optional<HANDLE> openHandle(String name) {
		Pointer pointer = new Pointer(OpenFileMappingA(new DWORD(VIEW_ACCESS), false, name));
		return validate(new HANDLE(pointer), handle -> handle.getPointer());
	}

	private void read(byte[] bytes, int n) {
		read(bytes, 0, n);
	}

	private void read(byte[] bytes, int offset, int n) {
		view.ifPresent(p -> p.read(0, bytes, offset, n));
	}

	private void read(int[] ints, int n) {
		view.ifPresent(p -> p.read(0, ints, 0, n));
	}

	private <T> Optional<T> validate(T handle, java.util.function.Function<T, Pointer> function) {
		if (Pointer.nativeValue(function.apply(handle)) != 0) {
			return ofNullable(handle);
		} else {
			return empty();
		}
	}

	private native long VirtualQuery(Pointer p, MEMORY_BASIC_INFORMATION infoOut, SIZE_T sz);

	private void write(byte[] data, int offset, int n) {
		view.ifPresent(p -> p.write(0, data, offset, Math.min(n, size)));
	}

}
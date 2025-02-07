export const toDataUrl = (blob: Blob): Promise<string> => {
  return new Promise<string>(resolve => {
    const fileReader = new FileReader();
    fileReader.onload = event => resolve(event?.target?.result as string);
    fileReader.readAsDataURL(blob);
  });
};

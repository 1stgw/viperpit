import Vue from "vue";
import VueResource from "vue-resource";
import type { Store } from "vuex";
import { toDataUrl } from "@/utils/toDataUrl";
import type { State } from ".";

const isServicesAvailable = async () => {
  try {
    const response = await Vue.http.get(`/services/control/state`);
    return response.ok;
  } catch (_error) {
    return false;
  }
};

const loadImage = async () => {
  try {
    const response = await Vue.http.get(`/services/cpd/image`, {
      headers: {
        accept: "image/png"
      },
      responseType: "blob"
    });

    if (!response.ok) {
      return null;
    }

    const data = await response.blob();
    if (data.size === 0) {
      return null;
    }

    return toDataUrl(data);
  } catch (_error) {
    return null;
  }
};

Vue.use(VueResource);

export default async function loaderPlugin(store: Store<State>) {
  const agentId = window.location.hostname;

  let eventSource: EventSource;

  const reconnect = () => {
    setTimeout(() => {
      requestAnimationFrame(() => {
        console.log("Reconnecting...");
        if (eventSource) {
          eventSource.close();
        }
        store.dispatch("disconnectAgent", agentId);
        loaderPlugin(store);
      });
    }, 1000);
  };

  if (!(await isServicesAvailable())) {
    reconnect();
    return;
  }

  eventSource = new EventSource("/services/cpd/is-image-ready");
  eventSource.addEventListener("error", () => reconnect());
  eventSource.addEventListener("message", async () => {
    const dataUrl = await loadImage();
    if (!dataUrl) {
      return;
    }
    store.dispatch("updateCenterPedestalDisplay", dataUrl);
  });

  store.dispatch("connectAgent", agentId);
  store.dispatch("initConfiguration");

  const dataUrl = await loadImage();
  if (!dataUrl) {
    return;
  }
  store.dispatch("updateCenterPedestalDisplay", dataUrl);
}

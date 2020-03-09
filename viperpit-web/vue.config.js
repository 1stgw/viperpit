module.exports = {
  devServer: {
    proxy: {
      "^/services/": {
        target: "http://[::1]:8090",
        ws: true,
        changeOrigin: true
      }
    }
  },
  lintOnSave: process.env.NODE_ENV !== "production"
};

module.exports = {
  devServer: {
    proxy: {
      "^/api/": {
        target: "http://[::1]:8090",
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          "^/api": ""
        }
      }
    }
  },
  lintOnSave: process.env.NODE_ENV !== "production"
};

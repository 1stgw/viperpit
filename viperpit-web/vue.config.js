module.exports = {
  lintOnSave: process.env.NODE_ENV !== "production",
  transpileDependencies: ["vuetify"],
  pluginOptions: {
    express: {
      shouldServeApp: true,
      serverDir: "./srv"
    }
  }
};

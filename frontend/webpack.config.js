const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
// const CracoLessPlugin = require('craco-less');

module.exports = {
  mode: 'development',
  // Where files should be sent once they are bundled
  output: {
    path: path.join(__dirname, '/dist'),
    filename: 'index.bundle.js',
  },
  // webpack 5 comes with devServer which loads in development mode
  devServer: {
    port: 3000,
    liveReload: true,
  },
  // Rules of how webpack will take our files, complie & bundle them for the browser
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /nodeModules/,
        use: {
          loader: 'babel-loader',
        },
      },
      {
        test: /\.(css|less)$/,
        use: [
          { loader: 'style-loader' },
          { loader: 'css-loader' },
          {
            loader: 'less-loader',
            options: {
              lessOptions: {
                // If you are using less-loader@5 please spread the lessOptions to options directly
                modifyVars: {
                  'primary-color': '#1DA57A',
                  'link-color': '#1DA57A',
                  'border-radius-base': '2px',
                },
                javascriptEnabled: true,
              },
            },
          },
        ],
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({ template: './public/index.html' }), //웹팩으로 빌드한 결과물로 HTML 파일을 생성해주는 플러그인
    // new webpack.ProgressPlugin(), // 웹팩의 빌드 진행율을 표시해주는 플러그인
  ],
};

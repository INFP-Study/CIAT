const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
// const CracoLessPlugin = require('craco-less');
const BundleAnalyzerPlugin =
  require('webpack-bundle-analyzer').BundleAnalyzerPlugin; //번들 시각화 도구

module.exports = {
  mode: 'development',
  // Where files should be sent once they are bundled
  entry: path.resolve(__dirname, '../src/index.js'),
  output: {
    path: path.join(__dirname, '/dist'),
    filename: 'index.bundle.js',
  },
  // webpack 5 comes with devServer which loads in development mode
  devServer: {
    port: 3000,
    liveReload: true,
    historyApiFallback: { index: '/', disableDotRule: true }, //라우트 사용 위해 추가
  },
  // Rules of how webpack will take our files, complie & bundle them for the browser
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: path.resolve(__dirname, '../node_modules'),
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
    new BundleAnalyzerPlugin({
      analyzerMode: 'server', // 기본값 "server"
      reportFilename: 'report.html', // 기본값 "report.html"
      openAnalyzer: false, // 기본값 true
    }),
    // new webpack.ProgressPlugin(), // 웹팩의 빌드 진행율을 표시해주는 플러그인
  ],
};

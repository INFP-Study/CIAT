import React from 'react';
import ReactDom from 'react-dom';
import Router from './lib/router';
import { store } from './store';
import { Provider } from 'react-redux';

ReactDom.render(
  <Provider store={store}>
    <Router />
  </Provider>,
  document.getElementById('root')
);

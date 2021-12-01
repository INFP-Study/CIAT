import React from 'react';
import ReactDom from 'react-dom';
import createSagaMiddleware from 'redux-saga';
import Router from './lib/router';
import { Provider } from 'react-redux';
import { configureStore } from '@reduxjs/toolkit';
import logger from 'redux-logger';
import rootReducer, { rootSaga } from './store';
import './style/theme.less';
import { createBrowserHistory } from 'history';

const sagaMiddleware = createSagaMiddleware();

const middleware =
  process.env.NODE_ENV === 'development'
    ? [sagaMiddleware, logger]
    : [sagaMiddleware];

const store = configureStore({
  reducer: rootReducer,
  middleware,
});

sagaMiddleware.run(rootSaga);

ReactDom.render(
  <Provider store={store}>
    <Router />
  </Provider>,
  document.getElementById('root')
);

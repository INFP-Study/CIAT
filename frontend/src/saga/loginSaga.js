import { put } from 'redux-saga/effects';
import * as loginStore from '../store/login';

function* loginTestSaga() {
  try {
    yield console.log('loginTestSaga test!');
  } catch (err) {
    console.log('loginTestSaga error!');
  }
}

export { loginTestSaga };

import { put } from 'redux-saga/effects';
import * as counterStore from '../store/counter';

function* incrementSaga() {
  try {
    yield console.log('incrementSaga test!');
    yield put({ type: counterStore.increment.type });
  } catch (err) {
    console.log('incrementSaga error!');
  }
}

function* decrementSaga() {
  try {
    yield console.log('decrementSaga test!');
    yield put({ type: counterStore.decrement.type });
  } catch (err) {
    console.log('decrementSaga error!');
  }
}

export { incrementSaga, decrementSaga };

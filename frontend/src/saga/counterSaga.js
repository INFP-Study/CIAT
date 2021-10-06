import { put } from 'redux-saga/effects';
import * as counterStore from '../store/counter';
import axios, { AxiosResponse } from 'axios';

import { INNER_ERROR } from '../constants';
import { finishLoading, startLoading } from '../store/loding';

function* getIncrementSaga() {
  try {
    yield put(startLoading(counterStore.getIncrement));
    const data = 'getIncrementSuccess!';
    yield put({
      type: counterStore.getIncrementSuccess,
      payload: data,
    });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const errorMessage = 'getIncrementAxiosError';
      yield put({
        type: counterStore.getIncrementFail,
        payload: errorMessage,
      });
    } else {
      yield put({
        type: counterStore.getIncrementFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(counterStore.getIncrement));
  }
}

function* getDecrementSaga() {
  try {
    yield put(startLoading(counterStore.getDecrement));
    const data = 'getDecrementSuccess!';
    yield put({
      type: counterStore.getDecrementSuccess,
      payload: data,
    });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const errorMessage = 'getDecrementAxiosError';
      yield put({
        type: counterStore.getDecrementFail,
        payload: errorMessage,
      });
    } else {
      yield put({
        type: counterStore.getDecrementFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(counterStore.getDecrement));
  }
}

export { getIncrementSaga, getDecrementSaga };

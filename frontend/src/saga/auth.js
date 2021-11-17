import { put } from 'redux-saga/effects';
import * as authStore from '../store/auth';
import { authAPI } from '../utils/api/auth';
import axios from 'axios';

import { INNER_ERROR } from '../constants';
import { finishLoading, startLoading } from '../store/loding';

function* googleLoginSaga(action) {
  try {
    yield put(startLoading(authStore.getGoogleLogin));
    const { data } = yield axios.get(authAPI.GOOGLE_LOGIN(params.payload));
    console.log(data);
    yield put({ type: authStore.getGoogleLoginSuccess, payload: data });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      yield put({
        type: authStore.getGoogleLoginFail,
        payload: errorMessage,
      });
    } else {
      console.log(e);
      yield put({
        type: authStore.getGoogleLoginFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(authStore.getGoogleLogin));
  }
}
export { googleLoginSaga };

import { put } from 'redux-saga/effects';
import * as authStore from '../store/auth';
import { SIGN_UP_API } from '../utils/api/auth';
import axios from 'axios';
import history from '../lib/router/history';

import { INNER_ERROR } from '../constants';
import { finishLoading, startLoading } from '../store/loding';
import { message, notification } from 'antd';

function* signUpSaga(action) {
  try {
    yield put(startLoading(authStore.signUp));
    const { data } = yield axios.post(SIGN_UP_API, action.data);
    yield put({ type: authStore.signUp, payload: data });
  } catch (e) {
    console.log(e);
    /* if(axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      yield put({
        type: authStore.
      })
    } */
  } finally {
    yield put(finishLoading(authStore.signUp));
  }
}

/* function* googleLoginSaga(action) {
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
} */
export { signUpSaga };

import { put } from 'redux-saga/effects';
import * as authStore from '../store/auth';
import { IS_SUCCESS, SIGN_IN_API, SIGN_UP_API } from '../utils/api/auth';
import axios from 'axios';
import { INNER_ERROR, SIGN_IN_ERROR, SIGN_UP_SUCCESS } from '../constants';
import { finishLoading, startLoading } from '../store/loding';
import { message, notification } from 'antd';

function* signInSaga(action) {
  try {
    const params = {
      email: action.data.email,
      password: action.data.password,
    };
    yield put(startLoading(authStore.signIn));
    const data = yield axios.post(SIGN_IN_API, params);
    axios.defaults.headers.common['Authorization'] = data.headers.authorization;
    const success = yield axios.get(IS_SUCCESS);
    yield put({
      type: authStore.signInSuccess,
      payload: success.config.headers.Authorization,
    });

    window.location.href = '/';
  } catch (error) {
    message.error(SIGN_IN_ERROR, 5);
    yield console.debug(error.response);
  } finally {
    yield put(finishLoading(authStore.signInSuccess));
  }
}

function* signUpSaga(action) {
  try {
    yield put(startLoading(authStore.signUp));
    const { data } = yield axios.post(SIGN_UP_API, action.data);
    yield put({ type: authStore.signUpSuccess, payload: data });
    notification.success({
      message: 'CIAT',
      description: SIGN_UP_SUCCESS,
    });

    //수정 예정
    setTimeout(() => {
      window.location.href = '/';
    }, 1500);
  } catch (e) {
    // 이메일 중복 확인 로직 추가예정
    alert('이미 등록된 이메일입니다.');
    if (axios.isAxiosError(e)) {
      console.log(e.response);
    }
    /* if (axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      console.log('errorMessage: ', errorMessage);
      yield put({
        type: authStore.signUp,
        payload: errorMessage,
      });
    } else {
      yield put({
        type: authStore.signUp,
        payload: INNER_ERROR,
      });
    } */
  } finally {
    yield put(finishLoading(authStore.signUpSuccess));
  }
}

export { signUpSaga, signInSaga };

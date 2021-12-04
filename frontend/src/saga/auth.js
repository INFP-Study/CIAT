import { put } from 'redux-saga/effects';
import * as authStore from '../store/auth';
import { SIGN_UP_API } from '../utils/api/auth';
import axios from 'axios';
import { INNER_ERROR, SIGN_UP_SUCCESS } from '../constants';
import { finishLoading, startLoading } from '../store/loding';
import { notification } from 'antd';

function* signInSaga(action) {
  /* let params = new URLSearchParams();
  params.append('email', 'dawwdawdadawdaw');
  params.append('password', '1234'); */
  /* axios
      .post('https://ciat-bakend.choicloudlab.com/api/v1/user/login', params)
      .then((response) => {
        console.log('Success');
        console.log(response.status);
        console.log(response.headers);
      })
      .catch((error) => {
        console.log('error');
        console.log(error.response.status);
      }); */
}

function* signUpSaga(action) {
  try {
    yield put(startLoading(authStore.signUpSuccess));
    const { data } = yield axios.post(SIGN_UP_API, action.data);
    yield put({ type: authStore.signUpSuccess, payload: data });
    notification.success({
      message: 'CIAT',
      description: SIGN_UP_SUCCESS,
    });
    //수정 예정
    window.location.href = '/';
  } catch (e) {
    // 이메일 중복 확인 로직 추가예정
    alert('이미 등록된 이메일입니다.');
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

export { signUpSaga };

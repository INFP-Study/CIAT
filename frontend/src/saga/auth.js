import { put } from 'redux-saga/effects';
import * as authStore from '../store/auth';
import { SIGN_IN_API, SIGN_UP_API } from '../utils/api/auth';
import axios from 'axios';
import { INNER_ERROR, SIGN_IN_SUCCESS, SIGN_UP_SUCCESS } from '../constants';
import { finishLoading, startLoading } from '../store/loding';
import { notification } from 'antd';

// 로그인 사가 수정 예정
function* signInSaga(action) {
  try {
    let params = new URLSearchParams();
    params.append('email', 'test-email-1209-01@test.com');
    params.append('password', '@test1234');
    axios
      .post('https://ciat-bakend.choicloudlab.com/api/v1/user/login', params)
      .then((response) => {
        console.log('Success');
        console.log(response.status);
        console.log(response.headers);
      })
      .catch((error) => {
        console.debug('error');
        console.log(error.response.status);
      });
  } catch (error) {
    console.debug(error);
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

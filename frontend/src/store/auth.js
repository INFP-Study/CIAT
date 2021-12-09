import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { signUpSaga, signInSaga } from '../saga/auth';

const initialState = {
  data: {
    email: '',
    nickname: '',
    password: '',
    passwordConfirm: '',
  },
  userId: '',
  isLogin: '',
  error: null,
};
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    signUp: (state) => state,
    signUpSuccess: (state, action) => {
      state.userId = action.payload;
      state.error = null;
      return state;
    },
    signUpFail: (state, action) => {
      state.error = action.payload;
      console.debug('error', action.payload);
      return state;
    },
    signInSuccess: (state, action) => {
      state.isLogin = action.payload;
      state.error = null;
      return state;
    },
    signInFail: (state, action) => {
      state.error = action.payload;
      console.debug('error', action.payload);
      return state;
    },
  },
});

const { actions, reducer: authReducer } = authSlice;

export const { signUp, signUpSuccess, signUpFail, signInSuccess, signInFail } =
  actions;

export { authReducer };

export function* authSaga() {
  yield takeLatest(signUp.type, signUpSaga);
  yield takeLatest(signInSuccess.type, signInSaga);
}

import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { signUpSaga } from '../saga/auth';

const initialState = {
  data: {
    email: '',
    nickname: '',
    password: '',
    passwordConfirm: '',
  },
};
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    signUp: (state, action) => {
      state = action.data;
      return state;
    },
  },
});

const { actions, reducer: authReducer } = authSlice;

export const { signUp } = actions;

export { authReducer };

export function* authSaga() {
  yield takeLatest(signUp.type, signUpSaga);
}

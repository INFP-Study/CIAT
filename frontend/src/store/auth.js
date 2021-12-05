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
  userId: '',
  error: null,
};
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
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
  },
});

const { actions, reducer: authReducer } = authSlice;

export const { signUpSuccess, signUpFail } = actions;

export { authReducer };

export function* authSaga() {
  yield takeLatest(signUpSuccess.type, signUpSaga);
}

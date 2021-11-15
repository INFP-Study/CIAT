import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { googleLoginSaga } from '../saga/auth';

const initialState = {
  googleSignup: {
    error: null,
  },
};
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    getGoogleLogin: (state) => state,
    getGoogleLoginSuccess: (state, action) => {
      state.user.userId = action.payload.userId;
      localStorage.setItem('user', action.payload.accessToken);
      return state;
    },
    getGoogleLoginFail: (state, action) => {
      state.googleSignup.error = action.payload;
      return state;
    },
  },
});

const { actions, reducer: authReducer } = authSlice;

export const { getGoogleLogin, getGoogleLoginSuccess, getGoogleLoginFail } =
  actions;

export { authReducer, initialState };

export function* authSaga() {
  yield takeLatest(getGoogleLogin.type, googleLoginSaga);
}

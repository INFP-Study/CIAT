import { createSlice } from '@reduxjs/toolkit';
import { takeLatest } from 'redux-saga/effects';
import { loginTestSaga } from '../saga/loginSaga';

const initialState = {
  value: 0,
};

const loginSlice = createSlice({
  name: 'login',
  initialState,
  reducers: {
    getLoginTest: (state) => state,
  },
});

const { actions, reducer: loginReducer } = loginSlice;

export const { getLoginTest } = actions;

export { loginReducer };

export function* loginSaga() {
  yield takeLatest(getLoginTest.type, loginTestSaga);
}

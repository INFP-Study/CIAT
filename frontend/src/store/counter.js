import { createSlice } from '@reduxjs/toolkit';
import { takeLatest } from 'redux-saga/effects';
import { getDecrementSaga, getIncrementSaga } from '../saga/counterSaga';

const initialState = {
  value: 0,
  error: null,
};

const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    getIncrement: (state) => state,
    getIncrementSuccess: (state, action) => {
      state.value += 1;
      state.error = null;
      console.debug('success', action.payload); //success
      return state;
    },
    getIncrementFail: (state, action) => {
      state.error = action.payload;
      console.debug('error', action.payload); //error
      return state;
    },
    getDecrement: (state) => state,
    getDecrementSuccess: (state, action) => {
      state.value -= 1;
      state.error = null;
      console.debug('success', action.payload); //success
      return state;
    },
    getDecrementFail: (state, action) => {
      state.error = action.payload;
      console.debug('error', action.payload); //error
      return state;
    },
  },
});

const { actions, reducer: counterReducer } = counterSlice;

export const {
  getIncrement,
  getIncrementSuccess,
  getIncrementFail,
  getDecrement,
  getDecrementSuccess,
  getDecrementFail,
} = actions;

export { counterReducer };

export function* counterSaga() {
  yield takeLatest(getIncrement.type, getIncrementSaga);
  yield takeLatest(getDecrement.type, getDecrementSaga);
}

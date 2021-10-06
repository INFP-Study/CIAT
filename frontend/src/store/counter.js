import { createSlice } from '@reduxjs/toolkit';
import { takeLatest } from 'redux-saga/effects';
import { decrementSaga, incrementSaga } from '../saga/counterSaga';

const initialState = {
  value: 0,
};

const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    getIncrement: (state) => state,
    increment: (state) => {
      state.value += 1;
      return state;
    },
    getDecrement: (state) => state,
    decrement: (state) => {
      state.value -= 1;
      return state;
    },
    incrementByAmount: (state, action) => {
      state.value += action.payload;
      return state;
    },
  },
});

const { actions, reducer: counterReducer } = counterSlice;

export const {
  getIncrement,
  increment,
  getDecrement,
  decrement,
  incrementByAmount,
} = actions;

export { counterReducer };

export function* counterSaga() {
  yield takeLatest(getIncrement.type, incrementSaga);
  yield takeLatest(getDecrement.type, decrementSaga);
}

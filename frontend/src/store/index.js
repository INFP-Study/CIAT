import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../utils/counterSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});

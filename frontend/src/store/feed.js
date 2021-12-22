import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { getFeedListSaga } from '../saga/feed';

const initialState = {
  feedList: [],
  feed: [],
  error: null,
};
const feedSlice = createSlice({
  name: 'feed',
  initialState,
  reducers: {
    getFeedList: (state) => state,
    getFeedListSuccess: (state, action) => {
      state.feedList = action.payload;
      return state;
    },
    getFeedListFail: (state, action) => {
      state.error = action.payload;
      return state;
    },
  },
});

const { actions, reducer: feedReducer } = feedSlice;

export const { getFeedList, getFeedListSuccess, getFeedListFail } = actions;

export { feedReducer, initialState };

export function* feedSaga() {
  yield takeLatest(getFeedList.type, getFeedListSaga);
}

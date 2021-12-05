import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { getMenuSaga, googleLoginSaga } from '../saga/menu';

const initialState = {
  menuList: [],
  error: null,
};
const menuSlice = createSlice({
  name: 'menu',
  initialState,
  reducers: {
    getMenuList: (state) => state,
    getMenuListSuccess: (state, action) => {
      state.menuList = action.payload;
      return state;
    },
    getMenuListFail: (state, action) => {
      state.menuList.error = action.payload;
      return state;
    },
  },
});

const { actions, reducer: menuReducer } = menuSlice;

export const { getMenuList, getMenuListSuccess, getMenuListFail } = actions;

export { menuReducer, initialState };

export function* menuSaga() {
  yield takeLatest(getMenuList.type, getMenuSaga);
}

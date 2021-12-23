import { takeLatest } from 'redux-saga/effects';
import { createSlice } from '@reduxjs/toolkit';
import { getMenuSaga, getCategorySaga } from '../saga/menu';

const initialState = {
  menuList: [],
  categoryList: [],
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
      state.error = action.payload;
      return state;
    },
    getCategoryList: (state) => state,
    getCategoryListSuccess: (state, action) => {
      state.categoryList = action.payload;
      return state;
    },
    getCategoryListFail: (state, action) => {
      state.error = action.payload;
      return state;
    },
  },
});

const { actions, reducer: menuReducer } = menuSlice;

export const {
  getMenuList,
  getMenuListSuccess,
  getMenuListFail,
  getCategoryList,
  getCategoryListSuccess,
  getCategoryListFail,
} = actions;

export { menuReducer, initialState };

export function* menuSaga() {
  yield takeLatest(getMenuList.type, getMenuSaga);
  yield takeLatest(getCategoryList.type, getCategorySaga);
}

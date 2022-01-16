import { put } from 'redux-saga/effects';
import * as menuStore from '../store/menu';
import { menuAPI } from '../utils/api/menu';
import axios from 'axios';

import { INNER_ERROR } from '../constants';
import { finishLoading, startLoading } from '../store/loding';

function* getMenuSaga() {
  try {
    yield put(startLoading(menuStore.getMenuList));
    const { data } = yield axios.get(menuAPI.GET_MENU);
    yield put({ type: menuStore.getMenuListSuccess, payload: data });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      yield put({
        type: menuStore.getMenuListFail,
        payload: errorMessage,
      });
    } else {
      console.log(e);
      yield put({
        type: menuStore.getMenuListFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(menuStore.getMenuList));
  }
}

function* getCategorySaga(action) {
  try {
    yield put(startLoading(menuStore.getCategoryList));
    const { data } = yield axios.get(
      menuAPI.GET_CATEGORYS + `?urlPath=${action.payload}`
    );

    yield put({ type: menuStore.getCategoryListSuccess, payload: data });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      yield put({
        type: menuStore.getCategoryListFail,
        payload: errorMessage,
      });
    } else {
      console.log(e);
      yield put({
        type: menuStore.getCategoryListFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(menuStore.getMenuList));
  }
}
export { getMenuSaga, getCategorySaga };

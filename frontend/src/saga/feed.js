import { put } from 'redux-saga/effects';
import * as feedStore from '../store/feed';
import { feedAPI } from '../utils/api/feed';
import axios from 'axios';

import { INNER_ERROR } from '../constants';
import { finishLoading, startLoading } from '../store/loding';

function* getFeedListSaga() {
  try {
    yield put(startLoading(menuStore.getFeedList));
    const { data } = yield axios.get(feedAPI.GET_FEEDLIST);
    yield put({ type: feedStore.getFeedListSuccess, payload: data });
  } catch (e) {
    if (axios.isAxiosError(e)) {
      const { errorMessage } = e.response.data;
      yield put({
        type: feedStore.getFeedListFail,
        payload: errorMessage,
      });
    } else {
      console.log(e);
      yield put({
        type: feedStore.getFeedListFail,
        payload: INNER_ERROR,
      });
    }
  } finally {
    yield put(finishLoading(feedStore.getFeedList));
  }
}

export { getFeedListSaga };

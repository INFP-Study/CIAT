import { all } from 'redux-saga/effects';
import { combineReducers } from 'redux';
import { counterReducer, counterSaga } from './counter';
import { loadingReducer } from './loding';
import { authReducer, authSaga } from './auth';
import { menuReducer, menuSaga } from './menu';
import { feedReducer } from './feed';

//리듀서 모음
const rootReducer = combineReducers({
  loading: loadingReducer,
  counter: counterReducer,
  auth: authReducer,
  menu: menuReducer,
  feed: feedReducer,
});

//사가 모음
export function* rootSaga() {
  try {
    yield all([counterSaga(), authSaga(), menuSaga()]);
  } catch (e) {
    throw new Error(e);
  }
}

export default rootReducer;

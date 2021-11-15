import { all } from 'redux-saga/effects';
import { combineReducers } from 'redux';
import { counterReducer, counterSaga } from './counter';
import { loadingReducer } from './loding';
import { authReducer, authSaga } from './auth';

//리듀서 모음
const rootReducer = combineReducers({
  loading: loadingReducer,
  counter: counterReducer,
  auth: authReducer,
});

//사가 모음
export function* rootSaga() {
  try {
    yield all([counterSaga(), authSaga()]);
  } catch (e) {
    throw new Error(e);
  }
}

export default rootReducer;

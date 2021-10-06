import { all } from 'redux-saga/effects';
import { combineReducers } from 'redux';
import { counterReducer, counterSaga } from './counter';
import { loadingReducer } from './loding';

//리듀서 모음
const rootReducer = combineReducers({
  loading: loadingReducer,
  counter: counterReducer,
});

//사가 모음
export function* rootSaga() {
  try {
    yield all([counterSaga()]);
  } catch (e) {
    throw new Error(e);
  }
}

export default rootReducer;

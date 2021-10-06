import { all } from 'redux-saga/effects';
import { combineReducers } from 'redux';
import { counterReducer, counterSaga } from './counter';
import { loginReducer, loginSaga } from './login';

//리듀서 모음
const rootReducer = combineReducers({
  counter: counterReducer,
  login: loginReducer,
});

//사가 모음
export function* rootSaga() {
  try {
    yield all([counterSaga(), loginSaga()]);
  } catch (e) {
    throw new Error(e);
  }
}

export default rootReducer;

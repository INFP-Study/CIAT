import { createSlice } from '@reduxjs/toolkit';

const loadingSlice = createSlice({
  name: 'loading',
  initialState: {
    'counter/getIncrement': false,
    'counter/getDecrement': false,

    'auth/getLogin': false,
    'auth/getUser': false,
    'auth/getSignup': false,

    'feed/getListItem': false,
    'feed/getItem': false,
    'feed/postItem': false,
    'feed/updateItem': false,
    'feed/removeItem': false,
  },
  reducers: {
    startLoading: (state, action) => ({ ...state, [action.payload]: true }),
    finishLoading: (state, action) => ({ ...state, [action.payload]: false }),
  },
});

const { actions, reducer: loadingReducer } = loadingSlice;
const { startLoading, finishLoading } = actions;
export { loadingReducer, startLoading, finishLoading };

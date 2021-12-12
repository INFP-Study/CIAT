import { API_END_POINT } from '.';

export const authAPI = {
  GOOGLE_LOGIN: `${API_END_POINT}/test`,
  GET_POST: (id) => `${API_END_POINT}/board/${id}`,
};

export const SIGN_UP_API =
  'https://ciat-bakend.choicloudlab.com/api/v1/user/signup';

export const SIGN_IN_API =
  'https://ciat-bakend.choicloudlab.com/api/v1/user/signin';

export const IS_SUCCESS =
  'https://ciat-bakend.choicloudlab.com/api/v1/user/success';

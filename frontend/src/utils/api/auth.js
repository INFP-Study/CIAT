const isDev = window.location.origin.includes('localhost');
const SERVER_ORIGIN = isDev
  ? 'http://localhost:3000'
  : 'https://ciat-bakend.choicloudlab.com';

export const API_DOMAIN = SERVER_ORIGIN;
export const API_END_POINT = `${SERVER_ORIGIN}/api`;

export const authAPI = {
  GOOGLE_LOGIN: `${API_END_POINT}/test`,
  GET_POST: (id) => `${API_END_POINT}/board/${id}`,
};

export const SIGN_UP_API =
  'https://ciat-bakend.choicloudlab.com/api/v1/user/signup';

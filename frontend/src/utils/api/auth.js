import { API_END_POINT } from '.';

export const authAPI = {
  GOOGLE_LOGIN: `${API_END_POINT}/test`,
  GET_POST: (id) => `${API_END_POINT}/board/${id}`,
};

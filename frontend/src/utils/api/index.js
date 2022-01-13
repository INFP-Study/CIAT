const isDev = window.location.origin.includes('localhost');
const SERVER_ORIGIN = isDev
  ? 'http://3.37.231.138:30501'
  : 'https://ciat-backend-dev-alpha.infp.svc:9400';

// const SERVER_ORIGIN = 'https://ciat-dev.choicloudlab.com';

export const API_DOMAIN = SERVER_ORIGIN;
export const API_END_POINT = `${SERVER_ORIGIN}/api/v1`;

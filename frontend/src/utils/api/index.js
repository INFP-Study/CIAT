const isDev = window.location.origin.includes('localhost');
// const SERVER_ORIGIN = isDev
//   ? 'http://localhost:3000'
//   : 'https://ciat-bakend.choicloudlab.com';

const SERVER_ORIGIN = 'https://ciat-bakend.choicloudlab.com';

export const API_DOMAIN = SERVER_ORIGIN;
export const API_END_POINT = `${SERVER_ORIGIN}/api/v1`;

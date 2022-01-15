import React from 'react';
import styled from 'styled-components';

const Wrapper = styled.div`
  position: absolute;
  width: 100vw;
  height: 100vh;
  z-index: 1000;
`;
function Mobile() {
  return <Wrapper>PC로 접속해 주세요.(크롬 이용 권장)</Wrapper>;
}

export default Mobile;

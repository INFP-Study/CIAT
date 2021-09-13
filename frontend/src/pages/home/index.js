import React from 'react';
import styled from 'styled-components';

const TitleTest = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: red;
`;

function index() {
  return (
    <div>
      <TitleTest>test</TitleTest>
      <br />
      home
    </div>
  );
}

export default index;

import { Card } from 'antd';
import React from 'react';
import styled from 'styled-components';

const ImageCard = styled(Card)`
  width: 400px;
  height: 400px;
  background: url('./image/식물이미지.png');
  background-size: cover;
`;

function Image() {
  return <ImageCard></ImageCard>;
}

export default Image;

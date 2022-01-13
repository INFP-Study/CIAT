import { Card } from 'antd';
import React from 'react';
import styled from 'styled-components';
import { theme } from '../../style/theme';

const InfoCard = styled(Card)`
  width: 303px;
  height: 190px;
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  font-weight: ${theme.weightMid};
`;

function Info(props) {
  const { title, content, a } = props.data;
  return (
    <InfoCard>
      <Title>{title}</Title>
      {content}
      <br />
      {a}
    </InfoCard>
  );
}

export default Info;

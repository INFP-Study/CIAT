import { Card, Timeline } from 'antd';
import React from 'react';
import styled from 'styled-components';
import { theme } from '../../style/theme';

const LogCard = styled(Card)`
  width: 303px;
  height: 190px;
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  font-weight: ${theme.weightMid};
`;

function Log({ title }) {
  return (
    <LogCard>
      <Title>{title}</Title>
      <Timeline>
        <Timeline.Item>
          2021-09-03 금요일
          <br />잘 자라나도록 영양제를 줬어요.
        </Timeline.Item>
        <Timeline.Item>
          2021-08-27 금요일
          <br />
          토마토, 처음 입양한 날!
        </Timeline.Item>
      </Timeline>
    </LogCard>
  );
}

export default Log;

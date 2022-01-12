import React from 'react';
import { Card, Timeline } from 'antd';
import styled from 'styled-components';

const CardAntd = styled(Card)`
  height: 47%;
  width: 40vh;
  .ant-card-head {
    min-height: 30px;
  }
  .ant-card-body {
    padding: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 17vh;
  }
  .ant-card-head-title {
    padding: 3px 0;
  }
  .ant-card-head-wrapper {
    height: 100%;
  }
`;

const TimelineAntd = styled(Timeline)`
  .ant-timeline-item {
    font-size: 1em;
    padding-bottom: 1px;
  }
  .ant-timeline-item-last > .ant-timeline-item-content {
    min-height: 30px;
    p {
      margin-bottom: 0;
    }
  }
`;

const Log = () => {
  return (
    <CardAntd hoverable title={'로그'} style={{ height: '47%' }}>
      <TimelineAntd>
        <Timeline.Item>
          2021-09-03 금요일 <p>잘 자라나도록 영양제를 줬어요.</p>
        </Timeline.Item>
        <Timeline.Item>
          2021-09-03 금요일 <p>토마토, 처음 입양한 날!</p>
        </Timeline.Item>
      </TimelineAntd>
    </CardAntd>
  );
};

export default Log;

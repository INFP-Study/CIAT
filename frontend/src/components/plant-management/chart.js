import { Card } from 'antd';
import React from 'react';
import styled from 'styled-components';
import { theme } from '../../style/theme';
import { Column, Pie } from '@ant-design/plots';

const ChartCard = styled(Card)`
  width: 400px;
  height: 400px;
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  font-weight: ${theme.weightMid};
`;

function Chart({ title, data }) {
  const Barconfig = {
    data,
    padding: 30,
    height: 300,
    xField: 'type',
    yField: 'value',
    meta: {
      type: {
        alias: '활동',
      },
      sales: {
        alias: '횟수',
      },
    },
    color: ({ type }) => {
      return theme.colorActivitiesChart[type];
    },
  };

  const Pieconfig = {
    appendPadding: 30,
    height: 300,
    data,
    angleField: 'value',
    colorField: 'type',
    radius: 1,
    innerRadius: 0.6,
    label: null,
    statistic: {
      title: false,
      content: null,
    },
    legend: {
      layout: 'horizontal',
      position: 'bottom',
    },
    color: ({ type }) => {
      return theme.colorStatusChart[type];
    },
  };

  return (
    <ChartCard>
      <Title>{title}</Title>
      {title === '최근 3개월 활동내역' ? (
        <Column {...Barconfig} />
      ) : (
        <Pie {...Pieconfig} />
      )}
    </ChartCard>
  );
}

export default Chart;

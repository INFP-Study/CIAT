import React from 'react';
import { Card } from 'antd';
import { Column } from '@ant-design/charts';
import styled from 'styled-components';

const colorObj = {
  '물주기': '#A0C4C9',
  '햇빛': '#DA9393',
  '통풍': '#97A8CB',
  '분갈이': '#DCC6A5',
  '영양': '#E3B074',
  '가지': '#7EA592',
  '분무': '#AD9CBB',
};

const AntdCard = styled(Card)`
  width: 100%;
  height: 100%;
  .ant-card-body {
    height: 33vh;
  }
`
const StateChart = () => {
  const data = [
    {
      type: '물주기',
      value: 1,
    },
    {
      type: '햇빛',
      value: 2,
    },
    {
      type: '통풍',
      value: 3,
    },
    {
      type: '분갈이',
      value: 4,
    },
    {
      type: '영양',
      value: 3,
    },
    {
      type: '가지',
      value: 2,
    },
    {
      type: '분무',
      value: 1,
    },
  ];


  const config = {
    data,
    xField: 'type',
    yField: 'value',
    seriesField: '',
    color: ({ type }) => {
      return colorObj[type];
    },
    label: {
      content: (originData) => {
      },
      offset: 10,
    },
    legend: false,
    xAxis: {
      label: {
        autoHide: true,
        autoRotate: false,
      },
    },
  };

  return (
    <div style={{height: '100%'}}>
      <AntdCard hoverable title={'최근 3개월 활동내역'}>
        <Column {...config} style={{ marginTop: '10px', height: '100%'}} />
      </AntdCard>
    </div>
  );
};

export default StateChart;
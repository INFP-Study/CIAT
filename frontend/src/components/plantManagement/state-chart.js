import React, { useEffect, useRef, useState } from 'react';
import { Card } from 'antd';
import { Column } from '@ant-design/charts';

const cardStyle = {
  width: '100%',
  height: '100%',
};

const colorObj = {
  '물주기': '#A0C4C9',
  '햇빛': '#DA9393',
  '통풍': '#97A8CB',
  '분갈이': '#DCC6A5',
  '영양': '#E3B074',
  '가지': '#7EA592',
  '분무': '#AD9CBB',
};
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

  const chartRef = useRef(null);
  const [chartHeight, setChartHeight ] = useState(220)
  useEffect(() => {
    setChartHeight(Math.floor(chartRef.current.offsetHeight * 0.8));
    console.log(chartHeight)
  })

  const config = {
    data,
    height: chartHeight,
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
    <div ref={chartRef} style={{height: '100%'}}>
      <Card hoverable style={cardStyle} title={'최근 3개월 활동내역'}>
        <Column {...config} style={{ marginTop: '10px' }} />
      </Card>
    </div>
  );
};

export default StateChart;
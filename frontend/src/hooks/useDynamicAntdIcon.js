import React, { useState } from 'react';
import { theme } from '../style/theme';
import * as AntdIcons from '@ant-design/icons';

function useDynamicAntdIcon(iconName) {
  const [icons, setIcons] = useState(AntdIcons);
  const TheIcon = icons[iconName];

  return <TheIcon style={{ fontSize: theme.fontSizeIcon }} />;
}

export default useDynamicAntdIcon;

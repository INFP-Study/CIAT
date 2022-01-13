import React, { useState } from 'react';
import { theme } from '../style/theme';
import * as io5Icons from 'react-icons/io5';
import * as bsIcons from 'react-icons/bs';
import * as biIcons from 'react-icons/bi';
import * as vscIcons from 'react-icons/vsc';
import * as ioIcons from 'react-icons/io';
import * as riIcons from 'react-icons/ri';

function useDynamicIcon(iconName) {
  const icons = {
    ...io5Icons,
    ...bsIcons,
    ...biIcons,
    ...vscIcons,
    ...ioIcons,
    ...riIcons,
  };
  const [icon, setIcons] = useState(icons);
  const TheIcon = icon[iconName];

  return (
    <TheIcon size={theme.fontSizeActivityIcon} style={{ color: '#C6C6C6' }} />
  );
}

export default useDynamicIcon;

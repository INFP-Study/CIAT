import { Footer } from 'antd/lib/layout/layout';
import React from 'react';
import styled from 'styled-components';
import { FOOTER } from '../../../constants';
import { theme } from '../../../constants/theme';

const Wrapper = styled(Footer)`
  text-align: center;
  background-color: ${theme.colorWhite};
`;

function SiteFooter() {
  return <Wrapper>{FOOTER}</Wrapper>;
}

export default SiteFooter;

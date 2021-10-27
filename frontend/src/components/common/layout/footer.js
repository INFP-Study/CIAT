import { Footer } from 'antd/lib/layout/layout';
import React from 'react';
import styled from 'styled-components';
import { FOOTER } from '../../../constants';
import { theme } from '../../../style/theme';

const FooterAntd = styled(Footer)`
  text-align: center;
  background-color: ${theme.colorWhite};
`;

function SiteFooter() {
  return <FooterAntd>{FOOTER}</FooterAntd>;
}

export default SiteFooter;
